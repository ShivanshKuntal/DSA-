import java.util.Scanner;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int turnaroundTime;

    public Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of processes
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        
        Process[] processes = new Process[n];

        // Input arrival and burst times for each process
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for process " + (i+1) + ": ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Enter burst time for process " + (i+1) + ": ");
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        // Calculating waiting time and turnaround time for each process
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            // Waiting time is current time minus arrival time
            if (currentTime < processes[i].arrivalTime) {
                currentTime = processes[i].arrivalTime;
            }
            processes[i].waitingTime = currentTime - processes[i].arrivalTime;
            // Turnaround time is waiting time plus burst time
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;
            // Update current time for the next process
            currentTime += processes[i].burstTime;
        }

        // Displaying the results
        System.out.println("\nProcess\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + processes[i].processId + "\t\t" + processes[i].arrivalTime + "\t\t" 
                               + processes[i].burstTime + "\t\t" + processes[i].waitingTime + "\t\t" 
                               + processes[i].turnaroundTime);
        }

        scanner.close();
    }
}
