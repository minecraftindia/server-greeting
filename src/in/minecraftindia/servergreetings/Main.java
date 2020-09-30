package in.minecraftindia.servergreetings;

import org.bukkit.plugin.java.JavaPlugin;

import in.minecraftindia.servergreetings.join.JoinListener;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new JoinListener(this);
		System.out.println(" &3------------------------");
		System.out.println("&3&l|       &a&lTEST PLUGIN      &3&l|");
		System.out.println("&3&l|________________________&3&l|");
	}
}
