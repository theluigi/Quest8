package edu.unca.jruggier.Quest8;


import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import edu.unca.jruggier.Quest8.Quest8CommandExecutor;
import edu.unca.jruggier.Quest8.Quest8EventListener;
import edu.unca.jruggier.Quest8.Quest8Logger;

@SuppressWarnings("unused")
public class Quest8 extends JavaPlugin {

	/*
	 * This is called when your plug-in is enabled
	 */
	Quest8Logger logger;

	@Override
	public void onEnable() {
		// create a logger and use it
		logger = new Quest8Logger(this);
		logger.info("plugin enabled");

		// save the configuration file
		saveDefaultConfig();

		// Create the SampleListener
		new Quest8EventListener(this);

		// set the command executor for sample
		this.getCommand("item").setExecutor(new Quest8CommandExecutor(this));
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {
		logger.info("plugin disabled");

	}
}
