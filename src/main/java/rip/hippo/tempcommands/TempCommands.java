package rip.hippo.tempcommands;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import rip.hippo.tempcommands.command.RunTempCommand;
import rip.hippo.tempcommands.command.TempCommand;

/**
 * @author Hippo
 */
public final class TempCommands extends JavaPlugin {

  @Override
  public void onEnable() {
    saveDefaultConfig();
    Bukkit.getPluginCommand("temp").setExecutor(new TempCommand(this));
    Bukkit.getPluginCommand("runtemp").setExecutor(new RunTempCommand(this));
  }
}
