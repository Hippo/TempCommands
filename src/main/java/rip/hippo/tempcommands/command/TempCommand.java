package rip.hippo.tempcommands.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * @author Hippo
 */
public final class TempCommand implements CommandExecutor {

  private final JavaPlugin javaPlugin;

  public TempCommand(JavaPlugin javaPlugin) {
    this.javaPlugin = javaPlugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!sender.hasPermission("tempcommands.command")) {
      return true;
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (String arg : args) {
      stringBuilder.append(arg).append(" ");
    }
    String message = stringBuilder.toString().trim();

    List<String> temp = javaPlugin.getConfig().getStringList("temp");
    temp.add(message);
    javaPlugin.getConfig().set("temp", temp);

    Bukkit.getScheduler().runTaskAsynchronously(javaPlugin, javaPlugin::saveConfig);

    return true;
  }
}
