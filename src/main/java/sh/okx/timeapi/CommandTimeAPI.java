package sh.okx.timeapi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import sh.okx.timeapi.api.TimeAPI;

public class CommandTimeAPI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0 && sender.hasPermission("timeapi.parse")) {
            try {
                TimeAPI timeAPI;
                String time = String.join(" ", args);
                long start = System.nanoTime();
                timeAPI = new TimeAPI(time);
                long end = System.nanoTime();

                sender.sendMessage(ChatColor.GOLD + "Results (" + ((end-start)/1_000_000f) + "ms):");
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Nanoseconds: " + timeAPI.getNanoseconds());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Microseconds: " + timeAPI.getMicroseconds());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Milliseconds: " + timeAPI.getMilliseconds());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Seconds: " + timeAPI.getSeconds());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Minutes: " + timeAPI.getMinutes());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Hours: " + timeAPI.getHours());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Days: " + timeAPI.getDays());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Weeks: " + timeAPI.getWeeks());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Months: " + timeAPI.getMonths());
                sender.sendMessage(ChatColor.GRAY + "- " + ChatColor.RESET + "Years: " + timeAPI.getYears());
            } catch(Exception ex) {
                sender.sendMessage(ChatColor.RED + "Error: " + ex.getMessage());
            }

            return true;
        }

        sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "TimeAPI " +
                JavaPlugin.getPlugin(PluginTimeAPI.class).getDescription().getVersion() +
                ChatColor.YELLOW + " by " + ChatColor.BLUE + "" + ChatColor.BOLD + "Okx");
        if(sender.hasPermission("timeapi.parse")) {
            sender.sendMessage(ChatColor.GREEN + "/timeapi <time> " + ChatColor.YELLOW + "Parses the given time");
        }
        return true;
    }
}
