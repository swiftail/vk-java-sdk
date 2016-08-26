package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.Actor;
import com.vk.api.sdk.objects.account.LookupResult;
import com.vk.api.sdk.queries.Field;

import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.lookupContacts method
 */
public class AccountLookupContactsQuery extends AbstractQueryBuilder<AccountLookupContactsQuery, LookupResult> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client  VK API client
     * @param actor   actor with access token
     * @param service value of "service" parameter.
     */
    public AccountLookupContactsQuery(VkApiClient client, Actor actor, String service) {
        super(client, "account.lookupContacts", LookupResult.class);
        accessToken(actor.getAccessToken());
        service(service);
    }

    /**
     * List of contacts separated with commas
     *
     * @param value value of "contacts" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountLookupContactsQuery contacts(String... value) {
        return unsafeParam("contacts", value);
    }

    /**
     * String identifier of a service which contacts are used for searching. May take the following values:
     * email
     * phone
     * twitter
     * facebook
     * odnoklassniki
     * instagram
     * google
     *
     * @param value value of "service" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected AccountLookupContactsQuery service(String value) {
        return unsafeParam("service", value);
    }

    /**
     * Contact of a current user on a specified service
     *
     * @param value value of "mycontact" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountLookupContactsQuery mycontact(String value) {
        return unsafeParam("mycontact", value);
    }

    /**
     * "1" - also return contacts found using this service before, "0" - return only contacts found using "contacts" field.
     *
     * @param value value of "return all" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountLookupContactsQuery returnAll(Boolean value) {
        return unsafeParam("return_all", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountLookupContactsQuery fields(Field... value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected AccountLookupContactsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("service", "access_token");
    }
}