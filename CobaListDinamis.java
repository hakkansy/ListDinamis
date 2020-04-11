/**
 *
 * @author Hakkan Syukri 1911082017
 * @author Andi Irham M 1911082006
 */
class NilaiMatkul{                                                   // Deklarasi class NilaiMatkul
    String nim;                                                      // Deklarasi tipe data String pada nim
    String nama;                                                     // Deklarasi tipe data String pada nama
    String nilai;                                                    // Deklarasi tipe data String pada nilai
    
    NilaiMatkul(){                                                   // Konstruktor untuk kelas NilaiMatkul
    }
    // Getter - Setter //
    public void setNim(String nim) {                                 // Setter nim
        this.nim = nim;                                              // Set this.nim dengan nilai nim
    }
    
    public String getNim() {                                         // Getter nim
        return nim;                                                  // Mengembalikan nilai nim
    }

    public void setNama(String nama) {                               // Setter nama
        this.nama = nama;                                            // Set this.nama dengan nilai nama
    }
    
    public String getNama() {                                        // Getter nama
        return nama;                                                 // Mengembalikan nilai nama
    }

    public String getNilai() {                                       // Getter nilai
        return nilai;                                                // Mengembalikan nilai "nilai"
    }

    public void setNilai(String nilai) {                             // Setter nilai
        this.nilai = nilai;                                          // Set this.nilai dengan nilai 'nilai'
    }       
}                                                                    // akhir class NilaiMatkul

class Elemen{                                                        // Deklarasi class Elemen
    NilaiMatkul kontainer;                                           // Deklarasi objek NilaiMatkul dengan nama kontainer
    Elemen next;                                                     // Deklarasi objek Elemen dengan nama next
    
    Elemen(){                                                        // Konstruktor untuk kelas Elemen
        kontainer = new NilaiMatkul();                               // Kontainer diisi dengan objek NilaiMatkul() yang baru
    }

    //getter-setter//
    public NilaiMatkul getKontainer() {                              // Getter kontainer
        return kontainer;                                            // Mengembalikan nilai kontainer
    }

    public void setNext(Elemen next) {                               // Setter next
        this.next = next;                                            // Set this.next dengan nilai next
    }    
    
    public Elemen getNext() {                                        // Getter next
        return next;                                                 // Mengembalikan nilai next
    }        
}                                                                    // Akhir class Elemen

class List{                                                          // Deklarasi class List
    private Elemen first;                                            // Deklarasi objek private Elemen dengan nama first;
    
    List() {                                                         // Konstruktor untuk kelas List
    }
    //getter-setter//
    public Elemen getFirst() {                                       // Getter first
        return first;                                                // Mengembalikan first
    }

    public void setFirst(Elemen first) {                             // Setter first
        this.first = first;                                          // Set this.first dengan nilai first
    }
    
    void createList(){                                               // Method membuat List
        first = null;                                                // Set first menjadi kosong / null
    }
    
    int countElement(){                                              // Method menghitung elemen
        int hasil = 0;                                               // hasil diset 0
        Elemen bantu;                                                // Deklarasi objek Elemen dengan nama bantu
        
        if(first != null)                                            // Jika first tidak kosong
        {
            bantu = first;                                           // Bantu diisi dengan nilai dari first 
            while(bantu != null){                                    // Ketika bantu tidak kosong
                hasil = hasil+1;                                     // hasil akan ditambah satu
                bantu = bantu.getNext();                             // Memanggil fungsi dari kelas Elemen.getNext();
          }
        }
        return hasil;                                                // Mengembalikan hasil
    }
    
    void addFirst(String nim, String nama, String nilai){            // Method addFirst (nilai Awal)
        Elemen baru;                                                 // Deklarasi objek Elemen dengan nama 'baru';
        baru = new Elemen();                                         // 'baru' diisi dengan nilai objek elemen baru
        baru.getKontainer().setNim(nim);                             // Memanggil fungsi Elemen.getKontainer yang didalamnya terdapat fungsi NilaiMatkul.setNim(); untuk mengisi nim.
        baru.getKontainer().setNama(nama);                           // Memanggil fungsi Elemen.getKontainer yang didalamnya terdapat fungsi NilaiMatkul.setNama(); untuk mengisi nama.
        baru.getKontainer().setNilai(nilai);                         // Memanggil fungsi Elemen.getKontainer yang didalamnya terdapat fungsi NilaiMatkul.setNilai(); untuk mengisi nama.
        
        if(first==null){                                             // Jika first kosong
            //list kosong
            baru.setNext(null);                                      // Data selanjutnya dikosongkan (Elemen.setNext dengan nilai null)
        }
        else{                                                        // first != null
            //list tidak kosong
            baru.setNext(first);                                     // Nilai "baru" diisi ke elemen pertama
        }
        first = baru;                                                // elemen pertama (first) diisi dengan baru
        baru = null;                                                 // "baru" dibuat kosong
    }
    
    void addAfter(Elemen prev, String nim, String nama, String nilai){  // Menambahkan elemen setelahnya 
        Elemen baru;                                                    // Deklarasi objek Elemen dengan nilai baru
        if(prev != null){                                               // jika elemen sebelumnya tidak kosong
            baru = new Elemen();                                        // elemem diisi dengan elemen "baru"
            baru.getKontainer().setNim(nim);                            // set nim baru
            baru.getKontainer().setNama(nama);                          // set nama baru
            baru.getKontainer().setNilai(nilai);                        // set nilai baru
            
            if(prev.next == null){                                      // jika elemen sebelumnya kosong
                baru.setNext(null);                                     // elemen "baru" diset nol
            }
            else{                                                       // jika tidak kosong
                baru.setNext(prev.getNext());                           // nilai "baru" diisi nilai elemen sebelumnya
            }
            prev.setNext(baru);                                         // nilai elemen selanjutnya diisi dengan elemen "baru"
            baru = null;                                                // elemen "baru" diset kosong
        }
    }
    
    void addLast(String nim, String nama, String nilai){             // Penambahan di elmen akhir
        Elemen last;                                                 // Deklarasi objek elemen dengan nama last sebagai elemen terakhir
        if(first == null){                                           // Jika elemen pertama (first) kosong
            //list kosong
            addFirst(nim, nama, nilai);                              // isi nilai elemen awal (memanggil addFirst)
        }
        else{                                                        // elemen pertama (first) tidak kosong
            //list kosong
            //cari elemen terakhir
            last = first;                                            // elemen last diisi dengan first
            while(last.getNext() != null){                           // selagi elemen last tidak kosong
                last = last.getNext();                               // element last diisi dengan last selanjutnya
            }
            addAfter(last, nim, nama, nilai);                        // isi elemen last dengan addAfter
        }
    }
    
    void delFirst(){                                                 // Hapus elemen awal (first)
        Elemen hapus;                                                // Deklarasi objek Elemen dengan nama "hapus"
        if(first != null){                                           // Jika elemen first tidak kosong
            hapus = first;                                           // elemen hapus diisi dengan elemen first
            if(countElement()==1){                                   // Jika isi elemen hanya 1
                first = null;                                        // elemen first dikosongkan
            }
            else{                                                    // Jika lebih dari satu
                first = first.getNext();                             // Elemen first diisi dengan elemen first selanjutnya
            }
                                                                     // kosongkan elemen hapus yang berisi element first sebelumnya.
            hapus.setNext(null);
        }
        else{                                                        // jika elemen first kosong
            System.out.println("List kosong, tidak bisa dihapus");   // error message
        }
    }
    
    void delAfter(Elemen prev){                                      // method delete after 
        Elemen hapus;                                                // deklarasi objek elemen dengan nama hapus
        if(prev != null){                                            // jika elemen sebelumnya tidak kosong
            hapus = prev.getNext();                                  // elemen hapus diisi dengan elemen sebelumnya.
            if(hapus != null){                                       // jika elemen hapus tidak kosong
                prev.setNext(null);                                  // elemen sebelumnya diisi kosong
            }
            else{                                                    // jika elemen hapus kosong
                prev.setNext(hapus.getNext());                       // elemen sebelumnya diisi dengan elemen hapus
            }
            //pengosongan elemen
            hapus.setNext(null);                                     // elemen hapus dikosongkan
          }
        }
  }
