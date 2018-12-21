package pers.zyc.demo.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhangyancheng
 */
public class ZoneDemo {

	public static void main(String[] args) {
		// 所有时区
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds.stream().collect(Collectors.joining(",")));

		List<String> zoneIdList = new ArrayList<>(allZoneIds);
		Collections.sort(zoneIdList);

		LocalDateTime ldt = LocalDateTime.now();
		for (String zid : zoneIdList) {
			ZoneId zone = ZoneId.of(zid);
			ZonedDateTime zdt = ldt.atZone(zone);
			System.out.println(zid + " " + zdt);
		}
	}
}
