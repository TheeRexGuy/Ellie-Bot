package el.bot;
import commands.Botcomms;
import logging.AllMessages;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class Botmain{

    private static final GatewayIntent[] getawaysIntents={GatewayIntent.MESSAGE_CONTENT,GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_MESSAGES,GatewayIntent.GUILD_MEMBERS};
    public static void main(String[] args) throws InterruptedException,IOException,InvalidTokenException{

        Botmain main=new Botmain();

        Properties properties = new Properties();
        FileInputStream input=new FileInputStream("config.properties");
        properties.load(input);

        JDABuilder jdaBuilder=JDABuilder.createDefault(properties.getProperty("bToken"), Arrays.asList(getawaysIntents));
        String logchannel = ""+properties.getProperty("targetchannel");



        JDA jda=jdaBuilder.addEventListeners(new Botcomms()).build().awaitReady();
        jda.addEventListener(new AllMessages(logchannel));

        jda.updateCommands().addCommands(Commands.slash("test","it tests the slash command")).queue();
        jda.updateCommands().addCommands(Commands.slash("testin", "replies with input").addOption(OptionType.STRING,"yourinput","takes your input", true)).queue();
    }
}