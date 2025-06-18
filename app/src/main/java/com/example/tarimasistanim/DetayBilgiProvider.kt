package com.example.tarimasistanim.data

data class BitkiDetay(
    val title: String,
    val description: String,
    val plantingInfo: String,
    val sulamaGunu: Int
)

object DetayBilgiProvider {
    fun getBilgi(id: Int): BitkiDetay {
        return when (id) {
            1 -> BitkiDetay(
                title = "Domates",
                description = "Domates, dünya genelinde en çok yetiştirilen sebzelerden biridir ve mutfakların vazgeçilmezidir. Vitamin ve mineral açısından zengin olan domates, C vitamini, potasyum ve likopen içerir. Sıcak iklimleri sever, güneşli ve iyi drene edilmiş topraklarda verimli olur. Bitkinin gelişimi için nemli fakat su basmanı olmayan toprak koşulları önemlidir.",
                plantingInfo = "Domates genellikle ilkbaharda, don riski geçtikten sonra fideler şeklinde veya tohumdan yetiştirilir. Fideler, 8-10 cm boyuna ulaştığında açık alana dikilir. Toprağın ısısı 15°C'nin üzerinde olmalıdır. Sulama düzenli olmalı, haftada 2-3 kez, toprağı nemli tutacak şekilde yapılmalıdır. Aşırı sulama kök çürümesine neden olabilir. Ayrıca bitkinin hava almasını sağlamak için yapraklara doğrudan su değdirilmemelidir.",
                sulamaGunu = 2
            )

            2 -> BitkiDetay(
                title = "Salatalık",
                description = "Salatalık, serin ve nemli iklimlerde hızlı gelişen, lif ve su oranı yüksek bir sebzedir. Sindirim sistemine faydası ve düşük kalorili yapısıyla diyetlerde sıkça tercih edilir. Tırmanıcı yapısı nedeniyle destek gerektirir ve güneşli, iyi drenajlı toprakları sever.",
                plantingInfo = "Tohumlar doğrudan açık toprağa ya da sıcaklık düşükse kapalı alanlarda ekilebilir. İlkbaharın son haftalarında, don tehlikesi ortadan kalktığında ekim yapılmalıdır. Salatalık bitkisi düzenli sulama ister; haftada 3-4 kez, özellikle sıcak havalarda su ihtiyacı artar. Sulama sabah erken saatlerde yapılarak yaprakların kuru kalması sağlanmalıdır.\n" +
                        "\n",
                sulamaGunu = 2
            )

            3 -> BitkiDetay(
                title = "Marul",
                description = "Marul, serin havayı seven, kısa sürede büyüyen bir yeşilliktir. Salataların ve sandviçlerin vazgeçilmezidir. Lif, vitamin A ve C açısından zengindir ve düşük kalorilidir. Toprağın hafif nemli ve hafif gölgeli olması gelişimini destekler.",
                plantingInfo = "Marul tohumları ilkbahar başında veya sonbahar başında doğrudan toprağa ekilir. Toprak nemli tutulmalı, aşırı sulamadan kaçınılmalıdır. Haftada 2-3 kez sulama yapılmalı, sulamalar toprak kuruduğunda gerçekleştirilmelidir. Hızlı büyüyen bir bitki olduğundan, sıcak günlerde güneşten biraz korunması faydalıdır.",
                sulamaGunu = 3

            )

            4 -> BitkiDetay(
                title = "Patlıcan",
                description = "Patlıcan, sıcak iklim sebzesidir ve uzun büyüme süresi gerektirir. Antioksidan özelliklere sahip, lif açısından zengin bir sebzedir. İyi drene edilmiş, humuslu topraklarda iyi gelişir. Patlıcan bitkisi yüksek sıcaklıklarda daha verimlidir.",
                plantingInfo = "Patlıcan fideleri, don tehlikesi geçtikten sonra, genellikle sonbahara kadar ekilir. Toprak sıcaklığı 18-20°C civarında olmalıdır. Sulama dengeli olmalı, toprak nemli kalmalıdır; haftada 2-3 kez sulama yeterlidir. Aşırı sulama kök çürümesine yol açabilir. Bitkinin hava almasını sağlamak için yapraklara doğrudan su değmemelidir.",
                sulamaGunu = 4
            )

            5 -> BitkiDetay(
                title = "Patates",
                description = "Patates, serin iklim sebzesi olup, nişasta açısından zengin ve enerji veren bir kök sebzesidir. Toprak yapısına ve iklime karşı oldukça hassastır. Hafif, nemli topraklarda en iyi verimi verir. Patates bitkisinin gelişimi toprak sıcaklığı ve nemine bağlıdır.",
                plantingInfo = "Patates yumruları, don tehlikesi geçtikten sonra, ilkbahar başlarında toprağa dikilir. Toprak 10-15°C arasında olmalıdır. Sulama düzenli yapılmalı, özellikle yumrular gelişirken toprak nemli tutulmalıdır. Haftada 2 kez derin sulama idealdir; yüzeysel sulama kök gelişimini olumsuz etkiler.\n" +
                        "\n",
                sulamaGunu = 4
            )

            6 -> BitkiDetay(
                title = "Brokoli",
                description = "Brokoli, sağlıklı bir yeşil sebzedir ve C vitamini, kalsiyum ile lif açısından zengindir. Serin iklimlerde daha iyi gelişir ve hafif gölgeli yerlerde yetiştirilmesi tavsiye edilir. Brokoli, soğuk hava koşullarına dayanıklıdır ve iyi bir kış sebzesidir.",
                plantingInfo = "Brokoli tohumları, ilkbahar veya sonbahar başında ekilir. Toprak nemli tutulmalı ve düzenli sulama yapılmalıdır. Haftada 2-3 kez sulama idealdir. Güneşli alanlarda yetiştirilse de aşırı sıcaklardan korunmalıdır. Fidelerin çok sık dikilmemesi, hava sirkülasyonunun sağlanması verim için önemlidir.",
                sulamaGunu = 3
            )

            7 -> BitkiDetay(
                title = "Havuç",
                description = "Havuç, uzun köklü, hafif tatlı aromalı bir sebzedir. Lif, A vitamini ve antioksidanlar açısından zengindir. Kumlu ve hafif topraklarda iyi gelişir. Soğuk havalara dayanıklıdır, erken ilkbaharda veya sonbaharda ekilir.",
                plantingInfo = "Havuç tohumları doğrudan toprağa ekilir, erken ilkbaharda toprak 8-10°C olunca ekim yapılabilir. Sulama, toprak sürekli nemli kalacak şekilde haftada 2-3 kez yapılmalıdır. Aşırı sulamadan kaçınılmalıdır, çünkü fazla su köklerin çürümesine neden olabilir. Toprağın hafif ve geçirgen olması, köklerin düzgün gelişmesi için gereklidir.",
                sulamaGunu = 4
            )

            else -> BitkiDetay(
                title = "BİLİNMEYEN",
                description = "Açıklama bulunamadı.",
                plantingInfo = "Ekim bilgisi bulunamadı.",
                sulamaGunu = 0
            )
        }
    }
}

//    fun getBilgi(title: String): BitkiDetay {
//        return when (title.uppercase()) {
//            "DOMATES" -> BitkiDetay(
//                title = "DOMATES",
//                description = "Domates sıcak iklimi sever. Bol güneşli yerde yetişir.",
//                plantingInfo = "İlkbaharda fide olarak ekilir. Sıcak aylarda toplanır."
//            )
//            "Brokoli" -> BitkiDetay(
//                title = "Brokoli",
//                description = "Brokoli serin iklimi seven bir sebzedir.",
//                plantingInfo = "Sonbaharda ekilir, kışa doğru hasat edilir."
//            )
//            "Havuc" -> BitkiDetay(
//                title = "Havuc",
//                description = "Havuç serin iklimi seven bir sebzedir.",
//                plantingInfo = "İlkbaharın başlarında ekilir ve yazın hasat edilir."
//            )
//            "Patates" -> BitkiDetay(
//                title = "Patates",
//                description = "Patates serin iklimi seven bir sebzedir.",
//                plantingInfo = "Bölgemizde dikim zamanı Şubat-Mart aylarıdır."
//            )
//            "Patlican" -> BitkiDetay(
//                title = "Patlican",
//                description = "Patlıcan serin iklimi seven bir sebzedir.",
//                plantingInfo = "Aralık –Ocak aylarında ekilmelidir. Fideler ise Mart-Nisan aylarında dikilir."
//            )
//            "Marul" -> BitkiDetay(
//                title = "Marul",
//                description = "Marul serin iklimi seven bir sebzedir.",
//                plantingInfo = "İlkbahardaki son sert dondan birkaç hafta sonra veya sonbaharda dondan bir veya iki ay öncedir."
//            )
//            "Salatalik" -> BitkiDetay(
//                title = "Salatalik",
//                description = "Salatalık serin iklimi seven bir sebzedir.",
//                plantingInfo = "Bu sebzeler genellikle mayıs, haziran ve temmuz aylarında ekilir."
//            )
//            else -> BitkiDetay(
//                title = title,
//                description = "Açıklama bulunamadı.",
//                plantingInfo = "Ekim bilgisi bulunamadı."
//            )
//        }
//    }
//}
