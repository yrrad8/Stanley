package fr.xgouchet.packageexplorer.common;

import java.util.Comparator;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import fr.xgouchet.packageexplorer.common.sort.PackageSortByInstall;
import fr.xgouchet.packageexplorer.common.sort.PackageSortByName;
import fr.xgouchet.packageexplorer.common.sort.PackageSortByPackage;
import fr.xgouchet.packageexplorer.common.sort.PackageSortByUpdate;

public class Constants {

	public static final String EXTRA_PACKAGE_INFO = "package_info";

	public static final byte SORT_BY_NAME = 0;
	public static final byte SORT_BY_PACKAGE = 1;
	public static final byte SORT_BY_INSTALL = 2;
	public static final byte SORT_BY_UPDATE = 3;

	private Constants() {

	}

	public static final Comparator<PackageInfo> getComparator(PackageManager pm) {
		Comparator<PackageInfo> comp = null;

		switch (Settings.sSortMethod) {
		case SORT_BY_PACKAGE:
			comp = new PackageSortByPackage();
			break;
		case SORT_BY_INSTALL:
			comp = new PackageSortByInstall();
			break;
		case SORT_BY_UPDATE:
			comp = new PackageSortByUpdate();
			break;
		case SORT_BY_NAME:
		default:
			comp = new PackageSortByName(pm);
			break;
		}

		return comp;
	}

}