import net.vividnetwork.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinLeaveListener implements Listener {
	
	
	public VividNetwork plugin;

	public JoinLeaveListener(VividNetwork plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
            Player player = event.getPlayer();
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, plugin.getConfig().getInt("JumpStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 360000, plugin.getConfig().getInt("SpeedStrength")));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 360000, plugin.getConfig().getInt("SpeedStrength")));
    }
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
			Player player = event.getPlayer();
			if(!player.hasPermission("hub.bypass")) {
            player.teleport(new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("X"), plugin.getConfig().getInt("Y"), plugin.getConfig().getInt("Z")));
		}
	}
}
