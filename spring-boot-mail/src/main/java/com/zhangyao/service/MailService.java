package com.zhangyao.service;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 18, 2018 4:35:10 PM
 */
public interface MailService {

	public void sendSimpleMail(String to, String subject, String content);

	public void sendHtmlMail(String to, String subject, String content);

	public void sendAttachmentsMail(String to, String subject, String content, String filePath);

	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
