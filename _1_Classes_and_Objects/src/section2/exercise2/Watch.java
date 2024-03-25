package section2.exercise2;

class Watch {
    private int hours;

    private int minutes;

    private int seconds;

    public Watch(int hours, int minutes, int seconds) {
        //put your code here
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public Watch() {
        //assign all fields to 0
        //use this() with correct arguments here and in constructors below
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Watch(int hours, int minutes) {
        //assign seconds to 0
        //use this() with correct arguments
        setHours(hours);
        setMinutes(minutes);
        this.seconds = 0;
    }

    public Watch(int hours) {
        //assign minutes and seconds to 0
        //use this() with correct arguments
        setHours(hours);
        this.minutes = 0;
        this.seconds = 0;
    }

    public void update(int hours, int minutes, int seconds) {
        this.hours = this.hours + hours;
        this.minutes = this.minutes + minutes;
        this.seconds = this.seconds + seconds;

        if (this.hours >= 24) {
            this.hours = this.hours % 24;
        } else if(this.hours < 0) {
            this.hours = 24 + this.hours % 24;
        }

        if (this.minutes >= 60) {
            this.minutes = this.minutes % 60;
        } else if(this.minutes < 0) {
            this.minutes = 60 + this.minutes % 60;
        }

        if (this.seconds >= 60) {
            this.seconds = this.seconds % 60;
        } else if(this.seconds < 0) {
            this.seconds = 60 + this.seconds % 60;
        }

        setHours(this.hours);
        setMinutes(this.minutes);
        setSeconds(this.seconds);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours < 24) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        } else {
            this.seconds = 0;
        }
    }

    //do not change the toString() code
    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hours, minutes, seconds);
    }
}
