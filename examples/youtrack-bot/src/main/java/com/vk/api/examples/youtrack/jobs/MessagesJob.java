package com.vk.api.examples.youtrack.jobs;

import com.vk.api.examples.youtrack.Application;
import com.vk.api.examples.youtrack.callback.MessagesHandler;
import com.vk.api.examples.youtrack.storage.DataStorage;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.responses.GetByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Anton Tsivarev on 19.11.16.
 */
public class MessagesJob implements Job {

    private static final Logger LOG =org.slf4j.LoggerFactory.getLogger(MembersUpdateJob.class);
    private static final String LAST_MESSAGE_ID_KEY = "vk.bot.lastMessageId";

    private Integer lastMessageId = 0;
    private Integer groupId = 0;

    public MessagesJob() throws ClientException, ApiException {
        lastMessageId = DataStorage.getInstance().getInt(LAST_MESSAGE_ID_KEY);
        if (lastMessageId == 0) {
            GetByIdResponse getResponse = Application.vk().messages().getById(Application.actor(), lastMessageId).execute();

            if (!getResponse.getItems().isEmpty()) {
                lastMessageId = getResponse.getItems().get(0).getId();
                DataStorage.getInstance().add(LAST_MESSAGE_ID_KEY, String.valueOf(lastMessageId));
            }
        }

        groupId = Application.groupId();
    }

    @Override
    public void doJob() throws Exception {
        GetByIdResponse getResponse = Application.vk().messages()
                .getById(Application.actor(), lastMessageId)
                .execute();

        for (Message message : getResponse.getItems()) {
            MessagesHandler.parseMessage(groupId, message);

            if (lastMessageId < message.getId()) {
                lastMessageId = message.getId();
                DataStorage.getInstance().add(LAST_MESSAGE_ID_KEY, lastMessageId);
            }
        }
    }
}
