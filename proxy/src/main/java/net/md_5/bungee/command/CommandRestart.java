package net.md_5.bungee.command;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.chat.TextComponent;

public class CommandRestart extends Command
{
    public CommandRestart()
    {
        super( "restart", "bungeecord.command.restart" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        sender.sendMessage( new TextComponent( "§aDer Proxy-Restart is getting triggered..." ) );
        
        BungeeCord.isRestarting = true;
        
        BungeeCord.getInstance().stop();
    }
}
