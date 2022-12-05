/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservices;

import java.io.*;
import java.net.*;
import java.util.*;

class Translator extends Thread {

    Socket con;

    public Translator(Socket con) {
        this.con = con;
    }

    private static String getPageSource(String textToTranslate, String translateFrom, String translateTo) throws Exception {
        String pageUrl = String.format("https://translate.google.com/m?sl=%s&tl=%s&q=%s", translateFrom, translateTo, URLEncoder.encode(textToTranslate, "UTF-8"));
        //System.out.println(pageUrl);
        URL url = new URL(pageUrl);
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        StringBuilder pageSource = new StringBuilder();
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(15000);
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                pageSource.append(line + System.lineSeparator());
            }
            return pageSource.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return null;
    }

    public static String translate(String textToTranslate, String translateFrom, String translateTo) throws Exception {
        try {
            String pageSource = getPageSource(textToTranslate, translateFrom, translateTo);
            String[] translatedText1 = pageSource.split("\"result-container\">");
            String[] translatedText2 = translatedText1[1].split("</");
            return translatedText2[0];
        } catch (Exception e) {
            return "There was an error translating the text.";
        }
    }

    public void run() {
        try {
            System.out.println("Client " + TranslatorServer.clientNum + " is connected now!");

            BufferedReader bufr = new BufferedReader(new InputStreamReader(con.getInputStream()));
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            String textToTranslate;

            bufw.write("Enter text: ");
            bufw.newLine();
            bufw.flush();
            textToTranslate = bufr.readLine();

            String translatedText = Translator.translate(textToTranslate, Language.ARABIC, Language.ENGLISH);
            bufw.write("Translated text: " + translatedText);
            bufw.newLine();
            bufw.flush();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class TranslatorServer {

    static int clientNum = 0;

    public static void main(String[] args) throws Exception {
        
        try {
            ServerSocket translator = new ServerSocket(8778);
            System.out.println("Translator Server is running now ...");
            while (true) {
                new Translator(translator.accept()).start();
            }
        } catch (Exception e) {
            System.out.println("The server is down!");
        }

    }

}

class Language {

    public static String AUTO_DETECT = "auto";
    public static String AFRIKAANS = "af";
    public static String ALBANIAN = "sq";
    public static String AMHARIC = "am";
    public static String ARABIC = "ar";
    public static String ARMENIAN = "hy";
    public static String AZERBAIJANI = "az";
    public static String BASQUE = "eu";
    public static String BELARUSIAN = "be";
    public static String BENGALI = "bn";
    public static String BOSNIAN = "bs";
    public static String BULGARIAN = "bg";
    public static String CATALAN = "ca";
    public static String CEBUANO = "ceb";
    public static String CHICHEWA = "ny";
    public static String CHINESE_SIMPLIFIED = "zh-CN";
    public static String CHINESE_TRADITIONAL = "zh-TW";
    public static String CORSICAN = "co";
    public static String CROATIAN = "hr";
    public static String CZECH = "cs";
    public static String DANISH = "da";
    public static String DUTCH = "nl";
    public static String ENGLISH = "en";
    public static String ESPERANTO = "eo";
    public static String ESTONIAN = "et";
    public static String FILIPINO = "tl";
    public static String FINNISH = "fi";
    public static String FRENCH = "fr";
    public static String FRISIAN = "fy";
    public static String GALICIAN = "gl";
    public static String GEORGIAN = "ka";
    public static String GERMAN = "de";
    public static String GREEK = "el";
    public static String GUJARATI = "gu";
    public static String HAITIAN_CREOLE = "ht";
    public static String HAUSA = "ha";
    public static String HAWAIIAN = "haw";
    public static String HEBREW = "iw";
    public static String HINDI = "hi";
    public static String HMONG = "hmn";
    public static String HUNGARIAN = "hu";
    public static String ICELANDIC = "is";
    public static String IGBO = "ig";
    public static String INDONESIAN = "id";
    public static String IRISH = "ga";
    public static String ITALIAN = "it";
    public static String JAPANESE = "ja";
    public static String JAVANESE = "jw";
    public static String KANNADA = "kn";
    public static String KAZAKH = "kk";
    public static String KHMER = "km";
    public static String KOREAN = "ko";
    public static String KURDISH_KURMANJI = "ku";
    public static String KYRGYZ = "ky";
    public static String LAO = "lo";
    public static String LATIN = "la";
    public static String LATVIAN = "lv";
    public static String LITHUANIAN = "lt";
    public static String LUXEMBOURGISH = "lb";
    public static String MACEDONIAN = "mk";
    public static String MALAGASY = "mg";
    public static String MALAY = "ms";
    public static String MALAYALAM = "ml";
    public static String MALTESE = "mt";
    public static String MAORI = "mi";
    public static String MARATHI = "mr";
    public static String MONGOLIAN = "mn";
    public static String MYANMAR_BURMESE = "my";
    public static String NEPALI = "ne";
    public static String NORWEGIAN = "no";
    public static String PASHTO = "ps";
    public static String PERSIAN = "fa";
    public static String POLISH = "pl";
    public static String PORTUGUESE = "pt";
    public static String PUNJABI = "pa";
    public static String ROMANIAN = "ro";
    public static String RUSSIAN = "ru";
    public static String SAMOAN = "sm";
    public static String SCOTS_GAELIC = "gd";
    public static String SERBIAN = "sr";
    public static String SESOTHO = "st";
    public static String SHONA = "sn";
    public static String SINDHI = "sd";
    public static String SINHALA = "si";
    public static String SLOVAK = "sk";
    public static String SLOVENIAN = "sl";
    public static String SOMALI = "so";
    public static String SPANISH = "es";
    public static String SUNDANESE = "su";
    public static String SWAHILI = "sw";
    public static String SWEDISH = "sv";
    public static String TAJIK = "tg";
    public static String TAMIL = "ta";
    public static String TELUGU = "te";
    public static String THAI = "th";
    public static String TURKISH = "tr";
    public static String UKRAINIAN = "uk";
    public static String URDU = "ur";
    public static String UZBEK = "uz";
    public static String VIETNAMESE = "vi";
    public static String WELSH = "cy";
    public static String XHOSA = "xh";
    public static String YIDDISH = "yi";
    public static String YORUBA = "yo";
    public static String ZULU = "zu";
}
