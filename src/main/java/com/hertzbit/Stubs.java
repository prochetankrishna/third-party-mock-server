package com.hertzbit;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.hertzbit.utils.JsonUtil;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Stubs {

    private JsonUtil jsonUtil;
    public WireMockServer wireMockServer;

    public Stubs setUpWireMockServer() {
        this.wireMockServer = new WireMockServer(8096);
        this.wireMockServer.start();
        System.out.println(this.wireMockServer.baseUrl());
        this.jsonUtil = new JsonUtil();
        return this;
    }

    public Stubs resetWireMockServer() {
        this.wireMockServer.resetAll();
        return this;
    }

    public Stubs stubForSuccessfulTelesignResponse(String responseFileName) {
        this.wireMockServer.stubFor(post("/telesign/lookup")
                .withHeader("Content-Type", equalToIgnoreCase("application/json"))
                .withHeader("Accept", equalToIgnoreCase("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("json/" + responseFileName)));
        return this;
    }

    public Stubs status() {
        System.out.println("Stubs Started!");
        return this;
    }
}
