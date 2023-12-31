public class Proses {
	private int id;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int memory;
    private int yazicilar;
    private int tarayicilar;
    private int modemler;
    private int cds;
    private String status;

    public Proses(int id, int arrivalTime, int burstTime, int priority, int memory, int yazicilar, int tarayicilar, int modemler) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.memory = memory;
        this.yazicilar = yazicilar;
        this.tarayicilar = tarayicilar;
        this.modemler = modemler;
        this.cds = cds;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
	return status;
    }
    @Override
    public String toString() {
        return String.format("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%s",
                id, arrivalTime, priority, burstTime, memory, yazicilar, tarayicilar, modemler, cds, status);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getYazicilar() {
        return yazicilar;
    }

    public void setYazicilar(int yazicilar) {
        this.yazicilar = yazicilar;
    }

    public int getTarayicilar() {
        return tarayicilar;
    }

    public void setTarayicilar(int tarayicilar) {
        this.tarayicilar = tarayicilar;
    }

    public int getModemler() {
        return modemler;
    }

    public void setModemler(int modemler) {
        this.modemler = modemler;
    }

    public int getCds() {
        return cds;
    }

    public void setCds(int cds) {
        this.cds = cds;
    }



}
