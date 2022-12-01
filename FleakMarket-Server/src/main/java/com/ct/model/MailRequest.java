package com.ct.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther lxy
 * @Date 2022/11/21 - 11 -21 -16:43
 * @Description FleakMarket-Server
 */
@Data
public class MailRequest implements Serializable {
    /**
     * 接收人
     */
    private String sendTo;

    /**
     *  邮件主题
     */
    private String subject;

    /**
     *  邮件内容
     */
    private String text;

    /**
     *  附件路径
     */
    private String filePath;

}

