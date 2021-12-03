package brazil.craftableheads;

import java.util.Date;
import java.util.HashMap;

public class PlayerCooldownManager {
	private HashMap<String, Date> cooldowns = new HashMap<String, Date>();
	
	void updatePlayer(String name, Date time)
	{
		cooldowns.put(name, time);
	}
	
	Date getLastUsageTime(String name)
	{
		Date usageTime = cooldowns.get(name);
		if (usageTime == null)
		{
			usageTime = new Date();
			usageTime.setTime(0);
			cooldowns.put(name, usageTime);
		}
		return usageTime;
	}
}
