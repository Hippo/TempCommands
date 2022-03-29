package rip.hippo.tempcommands.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * @author Hippo
 */
public class RunTempCommand implements CommandExecutor {

  private final JavaPlugin javaPlugin;

  public RunTempCommand(JavaPlugin javaPlugin) {
    this.javaPlugin = javaPlugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!sender.hasPermission("tempcommands.command")) {
      return true;
    }
    sender.sendMessage(ChatColor.GREEN + "Running temp commands...");
    List<String> temp = javaPlugin.getConfig().getStringList("temp");
    for (String tempCommand : temp) {
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), tempCommand);
    }
    javaPlugin.getConfig().set("temp", null);
    Bukkit.getScheduler().runTaskAsynchronously(javaPlugin, javaPlugin::saveConfig);
    return true;
  }
}