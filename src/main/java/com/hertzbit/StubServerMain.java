package com.hertzbit;

public class StubServerMain {

    public static Stubs stubs = new Stubs();

    public static void main(String[] args) {
        stubs.setUpWireMockServer()
                .stubForSuccessfulTelesignResponse("TelesignSuccessfulResponse.json")
                .status();
    }
}
