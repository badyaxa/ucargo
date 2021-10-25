package badyaxa.ucargo.entity;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return System.getenv("TELEGRAM_BOT_NAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("TELEGRAM_BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Що ? " + message.getText());
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.getText().equals("/start") || message.getText().equalsIgnoreCase("назад") || message.getText().equalsIgnoreCase("на головну")) {
            String startMessage = "ТОВ ВВ-АТЛАНТ : \n вітає Вас ";

            sendMessage.enableMarkdown(true);
            sendMessage.setReplyMarkup(
                    getMenuKeyboard("тЕСТОВА КНОПКА1", "2-ГА КНОПКА", "Наявність", "Документи", "Контакти")
            );

            sendMessage.setText(startMessage);
        }

        if (message.getText().equalsIgnoreCase("breakfast")) {
            String menu = "Breakfast : \n";
            menu = menu + "egg\n";
            menu = menu + "tea\n";
            sendMessage.setText(menu);
        }
        if (message.getText().equalsIgnoreCase("dinner")) {
            String menu = "Dinner : \n";
            menu = menu + "pasta\n";
            menu = menu + "lasagna\n";
            sendMessage.setText(menu);
        }

        if (message.getText().equalsIgnoreCase("директор")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboardFour("Бухгалтер", "Експедиція", "Продаж", "На головну")
            );
            sendMessage.setText("Директор +380 96 155 95 95");
        }
        if (message.getText().equalsIgnoreCase("документи")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboardFour("Рахунок", "Видаткова", "Податкова", "Назад")
            );
            sendMessage.setText("Виберіть тип документу:");
        }
        if (message.getText().equalsIgnoreCase("наявність")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboardFour("По назві", "По категорії", "По виробнику", "Назад")
            );
            sendMessage.setText("Як шукати товар ?");
        }

        if (message.getText().equalsIgnoreCase("бухгалтер")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboardFour("Директор", "Експедиція", "Продаж", "На головну")
            );
            sendMessage.setText("Бухгалтер +380 98 72 444 71");
        }

        if (message.getText().equalsIgnoreCase("експедиція")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboardFour("Директор", "Бухгалтер", "Продаж", "Назад")
            );
            sendMessage.setText("Експедиція  +380 68 533 44 99");
        }

        if (message.getText().equalsIgnoreCase("продаж")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboardFour("Директор", "Бухгалтер", "Експедиція", "Назад")
            );
            sendMessage.setText("Відділ продажу +380 97 00 856 00");
        }

//        if (message.getText().toLowerCase().equals("назад")) {
//            sendMessage.setReplyMarkup(
//                    getMenuKeyboard("тЕСТОВА КНОПКА1", "2-ГА КНОПКА", "кнопка3", "4КНОПка", "Контакти")
//            );
//            sendMessage.setText("Головне меню:");
//        }

        if (message.getText().equalsIgnoreCase("контакти")) {
            sendMessage.setReplyMarkup(
                    getMenuKeyboard("Директор", "Бухгалтер", "Експедиція", "Продаж", "Назад")
            );
            sendMessage.setText("Виберіть контакт:");
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup getMenuKeyboard(String a, String b, String c, String d, String e) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardFrirstRow = new KeyboardRow();
        keyboardFrirstRow.add(a);
        keyboardFrirstRow.add(b);
        keyboardRows.add(keyboardFrirstRow);

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(c);
        keyboardSecondRow.add(d);
        keyboardRows.add(keyboardSecondRow);

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(e);
        keyboardRows.add(keyboardThirdRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getMenuKeyboardFour(String a, String b, String c, String d) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardFrirstRow = new KeyboardRow();
        keyboardFrirstRow.add(a);
        keyboardFrirstRow.add(b);
        keyboardFrirstRow.add(c);
        keyboardRows.add(keyboardFrirstRow);

//        KeyboardRow keyboardSecondRow = new KeyboardRow();
//        keyboardSecondRow.add(d);
//        keyboardRows.add(keyboardSecondRow);

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(d);
        keyboardRows.add(keyboardThirdRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}