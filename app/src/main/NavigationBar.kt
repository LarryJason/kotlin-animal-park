fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    title: String,
    badgeAmount: Int? = null
) {
    Icon(
        imageVector = if (isSelected) {selectedIcon} else {unselectedIcon},
        contentDescription = title
    )
}