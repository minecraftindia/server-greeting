package in.minecraftindia.servergreetings.join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import in.minecraftindia.servergreetings.Main;
import in.minecraftindia.servergreetings.utils.Utils;


public class JoinListener implements Listener {
	
	private static Main plugin;
	
	@SuppressWarnings("static-access")
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPlayedBefore()) {
			
			e.setJoinMessage(Utils.chat(plugin.getConfig().getString("firstJoin_message").split(";")[rng.RnG(plugin.getConfig().getString("firstJoin_message").split(";").length)].replace("<player>", p.getName())));
			
		} else {
			e.setJoinMessage(Utils.chat(plugin.getConfig().getString("join_message").split(";")[rng.RnG(plugin.getConfig().getString("join_message").split(";").length)].replace("<player>", p.getName())));
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent d) {
		Player p = d.getEntity().getPlayer();
		Player k = d.getEntity().getKiller();
				
		d.setDeathMessage(Utils.chat(plugin.getConfig().getString("death_message").split(";")[rng.RnG(plugin.getConfig().getString("death_message").split(";").length)].replace("<player>", p.getName()).replace("<killer>", k.getName())));
		
	}

}
