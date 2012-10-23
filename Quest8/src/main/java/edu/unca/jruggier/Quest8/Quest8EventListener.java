package edu.unca.jruggier.Quest8;

/*
    This file is part of Quest8

    Foobar is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.world.ChunkLoadEvent;

public class Quest8EventListener implements Listener {
	private final Quest8 plugin;

	
	public Quest8EventListener(Quest8 plugin) {
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

		this.plugin = plugin;
	}
	
	/*
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage(
				this.plugin.getConfig().getString("sample.message"));
	*/
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		plugin.logger.info(event.getPlayer().getName() + " has left the server.");
		event.getPlayer().sendMessage("Goodbye " + event.getPlayer().getName());
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		plugin.logger.info("Watch out! " + event.getPlayer().getName() + " is sneaking around!");
		event.getPlayer().sendMessage(event.getPlayer().getName() + ", are you up to no good?");
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerBed(PlayerBedEnterEvent event) {
		plugin.logger.info(event.getPlayer().getName() + " has entered a bed.");
		event.getPlayer().sendMessage("Goodnight, " + event.getPlayer().getName());
		}	
	
	public void onPlayerDeath(PlayerDeathEvent event) {
		plugin.logger.info(event.getEntity().getName() + " has perished!");
		event.getEntity().sendMessage("Tis a pity, " + event.getEntity().getName() + "you lived a good life.");
	}
	

}