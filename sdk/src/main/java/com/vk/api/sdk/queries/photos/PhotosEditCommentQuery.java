package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.Actor;
import com.vk.api.sdk.objects.base.responses.OkResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.editComment method
 */
public class PhotosEditCommentQuery extends AbstractQueryBuilder<PhotosEditCommentQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client    VK API client
     * @param actor     actor with access token
     * @param commentId value of "comment id" parameter.
     */
    public PhotosEditCommentQuery(VkApiClient client, Actor actor, int commentId) {
        super(client, "photos.editComment", OkResponse.class);
        accessToken(actor.getAccessToken());
        commentId(commentId);
    }

    /**
     * ID of the user or community that owns the photo.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditCommentQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Comment ID.
     *
     * @param value value of "comment id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosEditCommentQuery commentId(int value) {
        return unsafeParam("comment_id", value);
    }

    /**
     * New text of the comment.
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditCommentQuery message(String value) {
        return unsafeParam("message", value);
    }

    /**
     * (Required if "message" is not set.) List of objects attached to the post, in the following format:
     * &lt;blockquote&gt;&lt;type&gt;&lt;owner_id&gt;_&lt;media_id&gt;,&lt;type&gt;&lt;owner_id&gt;_&lt;media_id&gt;&lt;/blockquote&gt;
     * "&lt;type&gt;" - Type of media attachment:
     * ''photo'' - photo
     * ''video'' - video
     * ''audio'' - audio
     * ''doc'' - document
     * "&lt;owner_id&gt;" - Media attachment owner ID.
     * "&lt;media_id&gt;" - Media attachment ID.
     * <p>
     * Example:
     * &lt;blockquote&gt;photo100172_166443618,photo66748_265827614&lt;/blockquote&gt;
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditCommentQuery attachments(String... value) {
        return unsafeParam("attachments", value);
    }

    @Override
    protected PhotosEditCommentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("comment_id", "access_token");
    }
}