package logging;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AllMessages extends ListenerAdapter
{
    private final String logChannelId;

    public AllMessages(String logChannelId) {
        this.logChannelId = logChannelId;
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot())
            return;

        String logchannel = logChannelId;
        String username = event.getAuthor().getName();
        String messageUrl = event.getMessage().getJumpUrl();
        String message = event.getMessage().getContentDisplay();
        String channel = event.getChannel().getName();
        String guild = event.getGuild().getName();

        TextChannel log = event.getJDA().getTextChannelById(logchannel);

        message = "**"+guild+"** | **#"+channel+"** | **"+username+"** : "+message;
        log.sendMessage(message+"\nURL: "+messageUrl).queue();
    }
}