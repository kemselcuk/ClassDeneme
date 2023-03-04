public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya= kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.examNote = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.examNote = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.examNote = kimya;
        }

    }
    public void addPracNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.pracNote= mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.pracNote = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.pracNote= kimya;
        }

    }

    public double ortMat(){
        return this.mat.ortNote= (this.mat.examNote*0.2)+(this.mat.pracNote*0.8);
    }
    public double ortFizik(){
        return this.fizik.ortNote= (this.fizik.examNote*0.3)+(this.fizik.pracNote*0.7);
    }
    public double ortKimya(){
        return this.kimya.ortNote= (this.kimya.examNote*0.4)+(this.kimya.pracNote*0.6);
    }

    public void calcAvarage() {
        this.avarage = (ortMat()+ortFizik()+ortKimya()) / 3;
    }
    public void isPass() {
        if (ortMat() == 0 || ortFizik() == 0 || ortFizik() == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("****************\nSınıfı Geçti.\n**************** ");
            } else {
                System.out.println("****************\nSınıfta Kaldı.\n****************");
            }
        }
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("======================================");
        System.out.println("Öğrenci : " + this.name+"\n--------------------");
        System.out.println("Matematik Sınav Notu : " + this.mat.examNote+"\nMatematik Sözlü Notu : "+this.mat.pracNote+"\nMatematik Ortalama Notu : "+this.mat.ortNote+"\n--------------------");
        System.out.println("Fizik Sınav Notu : " + this.fizik.examNote+"\nFizik Sözlü Notu : "+this.fizik.pracNote+"\nFizik Ortalama Notu : "+this.fizik.ortNote+"\n--------------------");
        System.out.println("Kimya Sınav Notu : " + this.kimya.examNote+"\nKimya Sözlü Notu: "+this.kimya.pracNote+"\nKimya Ortalama Notu  :"+this.kimya.ortNote+"\n--------------------");
    }
}
