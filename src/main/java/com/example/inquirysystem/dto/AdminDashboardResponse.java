package com.example.inquirysystem.dto;

public class AdminDashboardResponse {

    private long totalUsers;
    private long activeUsers;
    private long inactiveUsers;

    private long totalInquiries;
    private long requestedCount;
    private long completedCount;
    private long todayInquiries;

    private double completionRate;

    public AdminDashboardResponse(
            long totalUsers,
            long activeUsers,
            long inactiveUsers,
            long totalInquiries,
            long requestedCount,
            long completedCount,
            long todayInquiries,
            double completionRate
    ) {
        this.totalUsers = totalUsers;
        this.activeUsers = activeUsers;
        this.inactiveUsers = inactiveUsers;
        this.totalInquiries = totalInquiries;
        this.requestedCount = requestedCount;
        this.completedCount = completedCount;
        this.todayInquiries = todayInquiries;
        this.completionRate = completionRate;
    }

    public long getTotalUsers() { return totalUsers; }
    public long getActiveUsers() { return activeUsers; }
    public long getInactiveUsers() { return inactiveUsers; }
    public long getTotalInquiries() { return totalInquiries; }
    public long getRequestedCount() { return requestedCount; }
    public long getCompletedCount() { return completedCount; }
    public long getTodayInquiries() { return todayInquiries; }
    public double getCompletionRate() { return completionRate; }
}