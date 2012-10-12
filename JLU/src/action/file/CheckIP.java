package action.file;

public class CheckIP {

	public static boolean checkIP(String IP) {
		String[] ip = IP.split("\\.");
		switch (Integer.valueOf(ip[0])) {
		case 49:
			if (ip[1].equals("140")) {
				return true;
			} else {
				return false;
			}
		case 59:
			if (ip[1].equals("72")) {
				if (Integer.valueOf(ip[2]) <= 127) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		case 61:
			if (ip[1].equals("138")) {
				if (ip[2].equals("176")) {
					if (Integer.valueOf(ip[3]) >= 96
							&& Integer.valueOf(ip[3]) <= 127) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		case 111:
			if (ip[1].equals("116")) {
				if (Integer.valueOf(ip[2]) >= 96
						&& Integer.valueOf(ip[2]) <= 111) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		case 119:
			if (ip[1].equals("51")) {
				if (ip[2].equals("92")) {
					if (Integer.valueOf(ip[3]) >= 16
							&& Integer.valueOf(ip[3]) <= 23) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		case 202:
			switch (Integer.valueOf(ip[1])) {
			case 98:
				if (ip[2].equals("13") || ip[2].equals("17")) {
					return true;
				}
				if (ip[2].equals("18")) {
					if (Integer.valueOf(ip[3]) <= 127
							|| Integer.valueOf(ip[3]) >= 224) {
						return true;
					} else {
						return false;
					}
				}
			case 111:
				if (ip[2].equals("177")) {
					if (Integer.valueOf(ip[3]) >= 224) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			case 127:
				if (ip[2].equals("245")) {
					return true;
				} else {
					return false;
				}
			case 198:
				if (Integer.valueOf(ip[2]) >= 16
						&& Integer.valueOf(ip[2]) <= 79) {
					return true;
				} else {
					if (Integer.valueOf(ip[2]) >= 144
							&& Integer.valueOf(ip[2]) <= 175) {
						return true;
					} else {
						return false;
					}
				}
			default:
				return false;
			}
		case 219:
			if (ip[1].equals("217")) {
				if (Integer.valueOf(ip[2]) <= 15) {
					return true;
				} else {
					if (Integer.valueOf(ip[2]) >= 48
							&& Integer.valueOf(ip[2]) <= 63) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		case 222:
			if (ip[1].equals("27")) {
				if (Integer.valueOf(ip[2]) >= 64
						&& Integer.valueOf(ip[2]) <= 95) {
					return true;
				} else {
					return false;
				}
			} else {
				if (ip[1].equals("168")) {
					if (ip[2].equals("40") || ip[2].equals("41")) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		default:
			return false;
		}
	}
}
