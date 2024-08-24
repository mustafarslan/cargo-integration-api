#### WELCOME TO TRENDYOL HIRINGDAY

# Kargo Provider Entegrasyon Projesi

### Açıklama:


Kargo provider entegrasyon projesi ile kargo fimalari ile trendyol arasindaki kargo islemleri takip edilmektedir.

#### Entegrasyonlarda aşağıdaki işlevler yer almaktadır;

* **createPackageDelivery**: Paket olusturma islemini gerceklestirir.
* **fastDelivery**: Max 1 gun (24 saat) icinde teslimat yapilabilmektedir.
* **refund**: Kargo iadesi yapilabilmektedir.
* **addressResolve**: Kargonun musteri adresine teslimatinin yapabilmesini saglar.

Yukarıda saydığımız işlemler projede her kargo sağlayıcı için ayrı ayrı entegre edilir.Yapılan entegrasyonları kullanabilmek için REST katmanı oluşturulmuştur. Verilen projede “PTT”, “ARAS” gibi kargo sağlayıcılara ait entegrasyonlar **tamamlanmış durumdadır.**

#### Projedeki Kargo Sağlayıcılar;

Tum kargo firmalari paket tasima islemi gerceklestirebilir.(“createPackageDelivery“)

* **Ty Express**:  iade,adrese teslimat ve hizli teslimati desteklemektedir.

* **PTT**: Sadece adrese teslimat yapabilir.
  
* **Aras** : Iade edebilme ve hizli teslimati gerceklestirebilir.

#### Projede aşağıdaki işlemler tamamlanmıştır;

* ARAS kargo sağlayıcısına ait “createPackageDelivery”, “refund” ve “fastDelivery” işlevleri entegre edilmiştir. Aras kargo sağlayıcısı “addressResolve” (adrese teslimat) işlevi desteklememektedir.
* PTT kargo sağlayıcısı altındaki “createPackageDelivery” ve “addressResolve” (adrese teslimat)  işlevleri entegre edilmiştir. “PTT” kargo saglayicisi “refund” ve “fastDelivery”  işlevi desteklememektedir.
* Tamamlanan entegrasyonlara ait Request/Response sınıfları hazırlanmıştır.
* Yapılan kargo entegrasyonlarını kullanabilmek için REST katmanı hazırlanmıştır.
* Tamamlanan entegrasyonlara ait birim testleri yazılmıştır.


#### Yapılması istenenler:

1 - TYExpress'e ait entegrasyonlardan en az birinin yapilmasidir.(“refund”,“fastDelivery” yada “addressResolve” )

4 - Projede önceden yazılmış kodlar da dahil olmak üzere SOLID, Clean Code, OOP prensipleri açısından her türlü refactoring işlemini gerçekleştirmeniz beklenmektedir.

5 - Projede yeni yapılacak entegrasyonlara ait birim testlerini yazmanız gerekmektedir.
