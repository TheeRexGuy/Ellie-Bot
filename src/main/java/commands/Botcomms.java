package commands;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Botcomms extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        OptionMapping option = null;
        switch(event.getName()) {
            case "test":
                event.reply("positive").queue();
                break;
            case "testin":
                option = event.getOption("yourinput");
                if (option == null) {
                    event.reply("some error occurred").queue();
                    return;
                }
                break;
            default:
                return;
        }
        String input = option.getAsString();
        event.reply(input).queue();
        System.out.println(event.getUser().getName() + " " + event.getTimeCreated());
    }
}