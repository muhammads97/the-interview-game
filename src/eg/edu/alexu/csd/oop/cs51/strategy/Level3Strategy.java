package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class Level3Strategy implements Strategy {
    private List<Class<? extends Movable>> supported;
	private List<String> allSkills;
	private static final int fireRate = 2;
    private static final boolean obaque = false;

	@Override
	public Map<String, Object> doOperation() {
		allSkills = GameInfo.getInstance().getAllSkills();
		supported = GameInfo.getInstance().getCompanyFactory().getSupportedCompanies();
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(supported);
			Collections.shuffle(allSkills);
			GameInfo.getInstance().addTask(
					new Task(allSkills.get(0), allSkills.get(1), allSkills.get(2), supported.get(0).getSimpleName()));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("fireRate", fireRate);
		map.put("obaque", obaque);
		return map;
	}

}