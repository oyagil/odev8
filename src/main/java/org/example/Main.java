package org.example;
import java.util.ArrayList;
import java.util.List;

// Departman sınıfı
class Departman {
    private TeamLead teamLead;
    private List<Personel> personelListesi;
    private List<String> görevListesi;

    public Departman(TeamLead teamLead) {
        this.teamLead = teamLead;
        this.personelListesi = new ArrayList<>();
        this.görevListesi = new ArrayList<>();
    }

    public void teamLeadDeğiştir(TeamLead yeniTeamLead) {
        this.teamLead = yeniTeamLead;
    }

    public void personelEkle(Personel personel) {
        personelListesi.add(personel);
    }

    public void personelÇıkar(Personel personel) {
        personelListesi.remove(personel);
    }

    public void personelDeğiştir(Personel eskiPersonel, Personel yeniPersonel) {
        int index = personelListesi.indexOf(eskiPersonel);
        if (index != -1) {
            personelListesi.set(index, yeniPersonel);
        }
    }

    public void görevEkle(String görev) {
        görevListesi.add(görev);
    }

    public void görevTamamlandı(String tamamlananGörev) {
        görevListesi.remove(tamamlananGörev);
    }
}

// TeamLead sınıfı
class TeamLead extends Personel {
    public TeamLead(String ad, String soyad, String doğumTarihi) {
        super(ad, soyad, doğumTarihi);
    }
}

// Personel sınıfı
class Personel {
    private String ad;
    private String soyad;
    private String doğumTarihi;

    public Personel(String ad, String soyad, String doğumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.doğumTarihi = doğumTarihi;
    }

    public int emeklilikYaşıHesapla() {
        return this instanceof Kadın ? 60 : 65;
    }
}

// Kadın sınıfı
class Kadın extends Personel {
    public Kadın(String ad, String soyad, String doğumTarihi) {
        super(ad, soyad, doğumTarihi);
    }
}

// Erkek sınıfı
class Erkek extends Personel {
    public Erkek(String ad, String soyad, String doğumTarihi) {
        super(ad, soyad, doğumTarihi);
    }
}

public class Main {
    public static void main(String[] args) {
        TeamLead lider = new TeamLead("Ahmet", "Yılmaz", "01.01.1980");
        Departman departman = new Departman(lider);

        Personel personel1 = new Erkek("Mehmet", "Demir", "15.06.1990");
        Personel personel2 = new Kadın("Ayşe", "Kaya", "20.03.1985");

        departman.personelEkle(personel1);
        departman.personelEkle(personel2);

        departman.görevEkle("Proje yönetimi");
        departman.görevEkle("Test senaryolarını hazırlama");

        System.out.println("Emeklilik yaşı - Mehmet: " + personel1.emeklilikYaşıHesapla());
        System.out.println("Emeklilik yaşı - Ayşe: " + personel2.emeklilikYaşıHesapla());
    }
}
