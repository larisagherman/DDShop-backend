package dd.projects.ddshop.service;

import dd.projects.ddshop.entity.Order;
import dd.projects.ddshop.entity.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine; // for Thymeleaf

    public void sendOrderConfirmationEmail(Order order) {
        Context context = new Context();
        if (order.getUserId() == null || order.getUserId().getEmail() == null) {
            throw new IllegalArgumentException("User email is missing from order");
        }
        context.setVariable("name", order.getUserId().getFirstName() + " " + order.getUserId().getLastName());
        context.setVariable("orderId", order.getId());
        context.setVariable("total", order.getTotalPrice());

        String html = templateEngine.process("order-confirmation", context);

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(order.getUserId().getEmail());
            helper.setSubject("Order Confirmation");
            helper.setText(html, true); // true = is HTML
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle error (log or throw)
        }
    }
    public void sendPasswordResetEmail(User user, String resetLink) {
        Context context = new Context();
        context.setVariable("name", user.getFirstName() + " " + user.getLastName());
        context.setVariable("resetLink", resetLink);

        String html = templateEngine.process("reset-password", context);

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(user.getEmail());
            helper.setSubject("Reset Your Password");
            helper.setText(html, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send reset email");
        }
    }


}

