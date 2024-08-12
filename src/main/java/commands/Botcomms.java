package commands;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Botcomms extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        if (event.getName().equals("test")) {
            event.reply("positive").queue();
        }
        else if (event.getName().equals("testin")) {
            OptionMapping option=event.getOption("yourinput");
            if(option==null) {
                event.reply("some error occurred").queue();
                return;
            }
            String input = option.getAsString();
            event.reply(input).queue();
            System.out.println(event.getUser().getGlobalName());
        }
    }
}
