package net.md_5.bungee.command;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class CommandRestart extends Command
{
    public CommandRestart()
    {
        // Wir fügen hier Aliasse hinzu, falls man sich vertippt
        super( "restart" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        // Permission-Abfrage NUR für Spieler, die Konsole darf immer!
        if ( sender.getName().equals( "CONSOLE" ) || sender.hasPermission( "bungeecord.command.restart" ) )
        {
            sender.sendMessage( new TextComponent( "§aInternal restart trigger active. Shutting down restart thread..." ) );

            BungeeCord.isRestarting = true;

            BungeeCord.getInstance().stop();
        } else
        {
            sender.sendMessage( new TextComponent( "§cYou do not have permission to execute this command!" ) );
        }
    }
}
