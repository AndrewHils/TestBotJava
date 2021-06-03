import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    String StickerID;
    boolean cat_dog = true;
    String first_massage = null;
    String start_msg = "Good day !\n" +
            "On the vastness of the worldwide network, did you somehow come across this particular bot?\n" +
            "Well then, let's get started!\n" +
            "Press 1 - to select Cute kitten" + Icon.CAT.get() + "\n" +
            "Press 2 - to select Adorable puppy" + Icon.DOG.get() + "\n";
    String info_msg = "Главная задача этого бота - проинформировать людей и тд и тп.....";
    String default_msg = "Sorry, I am not good at handling a command like this." + Icon.CRYING.get() + "\n" +
            "Please use the buttons below or enter the \"/\" symbol for help\n";
    String feed_msg = "Congratulations, you fed your pet!!!" + Icon.PIZZA.get() + "\n";
    String play_msg = "Congratulations, you played with your pet!!!" + Icon.BALL.get() + "\n";
    String wash_msg = "Congratulations, you washed your pet!!!" + Icon.WATTER.get() + "\n";


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    public void sendMsg(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            setButton(sendMessage);
            execute(sendMessage);
        }catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }
    public void setButton(SendMessage sendMessage)
    {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/feed"));
        keyboardFirstRow.add(new KeyboardButton("/wash"));
        keyboardFirstRow.add(new KeyboardButton("/play"));
        keyboardSecondRow.add(new KeyboardButton("/info"));

        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void sendPic(Message message, String stickerId)
    {
        InputFile inputFile = new InputFile();
        SendSticker sendSticker = new SendSticker(message.getChatId().toString(), inputFile.setMedia(stickerId));

        try {
            execute(sendSticker);
        }catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }


//    public void Heals_StaminaBar()
//    {
//        int heals = 100;
//        int stamina = 100;
//
//        ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
//        Runnable runnable = null;
//        ex.scheduleAtFixedRate(runnable, 0, 2, TimeUnit.HOURS);
//    }

    @Override
    public String getBotUsername() {
        return "MyNewTest123456789_bot";
    }

    @Override
    public String getBotToken() {
        return "1614203993:AAG9GADMQZ8gN0Ez0q5mhjh8Log6Lc9m3To";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        //Нужно засунуть в отдельный класс/библиотеку со стикерами
        //КОТЫ
        Sticker BOX = new Sticker();
        BOX.setFileId("CAACAgIAAxkBAANSYLhdcsRyL3qKNvyHvFpIRYt3YgYAArgKAALxIcFJW5HP0kqIib0fBA");
        Sticker FEEDED = new Sticker();
        FEEDED.setFileId("CAACAgIAAxkBAANUYLhdowvbxvnoed9RwpgNmZpZfAADEw8AAj1mwEk-NMr2v9bSRh8E");
        Sticker SED = new Sticker();
        SED.setFileId("CAACAgIAAxkBAANWYLhd3Jk72PUMhPmtdNsqzlRCidMAArgOAAKF4MBJDEgugcixGMMfBA");
        Sticker HUNGRY = new Sticker();
        HUNGRY.setFileId("CAACAgIAAxkBAANZYLheCpP5nqWx0qMTx7nUoZSNr6cAAjoPAAI9JsFJT5GKUQzgXVMfBA");
        Sticker DIRTY = new Sticker();
        DIRTY.setFileId("CAACAgIAAxkBAANeYLheMfMFLkGW5I1wr7gO6zjYe4AAtoNAAIdMcFJO2jGVHVayMfBA");
        Sticker PLAYFULL = new Sticker();
        PLAYFULL.setFileId("CAACAgIAAxkBAANgYLheSLlRVBWd-jXW5TFACV6H6aAAAloSAAIt7cFJXVoBKw5BxcofBA");
        Sticker SLEEP = new Sticker();
        SLEEP.setFileId("CAACAgIAAxkBAANiYLheWSl5LWKXBjUd5gZMGTuPaRYAAh8OAAIEZMBJQ1j1bscJCUEfBA");
        Sticker WASHED = new Sticker();
        WASHED.setFileId("CAACAgIAAxkBAAIBZGC4ZKmjvobtDi2YVfekwtx5X01AAIeDgAC57AScFsQXAqnypTHwQ");


        //Для получения FileID
//        if (message.hasSticker())
//        {
//            StickerID = message.getSticker().getFileId();
//            sendMsg(message,StickerID);
//        }


        //Как-то реализовать выбор между котом и псом
        if (message != null && message.hasText() && first_massage == "/start")
        {
            switch (message.getText()) {
                case "1":
                    sendPic(message, BOX.getFileId());
                    sendMsg(message, "You picked this awesome kitten!\n" + "Congrads!!!\n");
                    cat_dog = true;
                    first_massage = message.getText();
                    break;
                case "2":
                    sendMsg(message, "You picked this awesome doggy!\n" + "Congrads!!!\n");
                    cat_dog = false;
                    first_massage = message.getText();
                    break;
                default:
                    sendMsg(message, default_msg);
                    break;
            }

        }
        else if (message.getText().equals("/start"))
        {
            sendMsg(message , start_msg);
            first_massage = message.getText();
        }


        if (message != null && message.hasText() && cat_dog == true) {
            switch (message.getText()) {
                case "/info":
                    sendMsg(message , info_msg);
                    break;
                case "/feed":
                    sendMsg(message , feed_msg);
                    sendPic(message,FEEDED.getFileId());
                    break;
                case "/wash":
                    sendMsg(message , wash_msg);
                    sendPic(message,WASHED.getFileId());
                    break;
                case "/play":
                    sendMsg(message , play_msg);
                    sendPic(message,PLAYFULL.getFileId());
                    break;


                case "/start":
                    break;
                case "1":
                    break;
                case "2":
                    break;
                default:
                    sendMsg(message , default_msg);
                    break;
            }
        }
    }
}
