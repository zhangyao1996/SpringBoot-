package com.zhangyao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangyao.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {
	@Autowired
	private MailService mailService;

	@Test
	public void testSimpleMail() throws Exception {
		mailService.sendSimpleMail("2298992967@qq.com", "test simple mail", " hello this is simple mail");
	}

	@Test
	public void testHtmlMail() throws Exception {
		String content = "<html>\n" + "<body>\n" + "    <h3>hello world ! 这是一封html邮件!</h3>\n" + "</body>\n" + "</html>";
		mailService.sendHtmlMail("2298992967@qq.com", "test simple mail", content);
	}
	

    @Test
    public void sendAttachmentsMail() {
        String filePath="e:\\资料\\1代码大全2中文版（高清晰完美PDF版，索引完整）.pdf";
        mailService.sendAttachmentsMail("2298992967@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

}
