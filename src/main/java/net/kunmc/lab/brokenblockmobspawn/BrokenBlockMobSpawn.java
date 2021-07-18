package net.kunmc.lab.brokenblockmobspawn;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class BrokenBlockMobSpawn extends JavaPlugin {

    public static int probability = 5;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BBEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean same(String a, String b) {
        return a.equals(b);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            // help
            if (same(args[0], "help")) {
                final String[] HELP_MESSAGE = {
                        "-------------- [ " + ChatColor.GREEN + "FindHim Plugin" + ChatColor.RESET + " ] ---------------",
                        "/BBMS help : ヘルプ表示",
                        "/BBMS kakuritsu <int>: 確率を指定",
                        "--------------------------------------------",
                };
                Stream.of(HELP_MESSAGE).forEach(sender::sendMessage);
                return true;
            }


        }
        if (args.length == 2 && same(args[0], "kakuritsu")) {
            if(setKakuritsu(args[1])){
                sender.sendMessage(String.format("確率 が 1/%s に設定されました。", args[1]));
                return true;
            }
            sender.sendMessage(" 不正な引数です。");
            return false;
        }
        return true;
    }

    public static boolean setKakuritsu(String k){
        try {
            int intK = Integer.parseInt(k);
            if (intK>0) {
                probability = intK;
                return true;
            }
        } catch (Exception ignore) {
            // do nothing
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Stream.of("help",  "kakuritsu")
                    .filter(e -> e.startsWith(args[0]))
                    .collect(Collectors.toList());
        }

        // kakuritsu
        if (args.length == 2 && same(args[0], "kakuritsu")) {
            if (args[1].length() == 0) {
                return Collections.singletonList("5");
            }
        }


        return null;
    }
}
