package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.Actor;
import com.vk.api.sdk.objects.groups.responses.GetMembersFilterResponse;

import java.util.Collections;
import java.util.List;

/**
 * Query for Groups.getMembers method
 */
public class GroupsGetMembersQueryWithFilter extends AbstractQueryBuilder<GroupsGetMembersQueryWithFilter, GetMembersFilterResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor  actor with access token
     */
    public GroupsGetMembersQueryWithFilter(VkApiClient client, Actor actor, String filter) {
        super(client, "groups.getMembers", GetMembersFilterResponse.class);
        accessToken(actor.getAccessToken());
        filter(filter);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     */
    public GroupsGetMembersQueryWithFilter(VkApiClient client, String filter) {
        super(client, "groups.getMembers", GetMembersFilterResponse.class);
        filter(filter);
    }

    /**
     * ID or screen name of the community.
     *
     * @param value value of "group id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetMembersQueryWithFilter groupId(String value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Sort order. Available values: ''id_asc'', ''id_desc'', ''time_asc'', ''time_desc''.
     * ''time_asc'' and ''time_desc'' are availavle only if the method is called by the group's "moderator".
     *
     * @param value value of "sort" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetMembersQueryWithFilter sort(String value) {
        return unsafeParam("sort", value);
    }

    /**
     * Offset needed to return a specific subset of community members.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetMembersQueryWithFilter offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of community members to return.
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0. By default 1000.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetMembersQueryWithFilter count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * "friends" - only friends in this community will be returned;
     * "unsure" - only those who pressed 'I may attend' will be returned (if it's an event).
     *
     * @param value value of "filter" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsGetMembersQueryWithFilter filter(String value) {
        return unsafeParam("filter", value);
    }

    @Override
    protected GroupsGetMembersQueryWithFilter getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Collections.EMPTY_LIST;
    }
}