package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachImage {

    @Attachment(type = "image/png", value = "failed tests")
    public static byte[] makeImageAttachment(String attachmentName, byte[] source) {
        return source;
    }
}
