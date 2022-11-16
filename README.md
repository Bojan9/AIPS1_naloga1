# AIPS1_naloga1

Treba da napravam calculator koj ke raboti vo consola so reverse polish notation.

pr. > 2 3 + -> 5

Programot treba da ni raboti so skladovi (Stacks) samo sto mora nie da gi isprogramirame ne smeeme da koristime biblioteki, jas vekje ova go imam napraveno. Skladot ima tri funkcii: top() -> ti pokazuva koj e najgoren element, pop() -> ti pokazuva najgolem element i go trga, push(x) -> stava najgore nov element. So pomos na Stackot pravime i drugi operacii kako slednive (ovie vekje gi imam napraveno):

`> 1 2 3 -> na skladot gi stava elementite 1 2 3`<br>
`> 1 2 3 echo -> 3`<br>
`> 1 2 3 pop -> (1 2)`<br>
`> 1 2 3 dup -> (1 2 3 3)`<br>
`> 1 2 3 dup2 -> (1 2 3 2 3)`<br>
`> 1 2 3 swap -> (1 3 2)`<br>
`> 66 char -> (B)`<br>
`> 2 even -> (1)`<br>
`> 2 odd -> (0)`<br>
`> 3 ! -> (6) `<br>
`> 234 len -> (3)`<br>
`> <>, <, <=, ==, >, >=`<br>
`> +, -, *, /, %`<br>
`> 2 3 . -> (23)`<br>
`> 2 4 rnd -> (random br. od 2 do 4)`<br>

Site ovie mi rabotat na 0-tiot sklad. Ostanatite nekolku funkcii ke treba da mi rabotat na povekje skladovi, ne samo na 0-tiot. Forata e site skladovi da gi stavime na eden Sequence koj ke moze da ima vo nego max 42 sklada. Sequence raboti isto(slicno) ko skladot samo sto koristi i indeksi. Negovite funkcii se: get(int i) zima odreden element i add(x) stava element najgore. Slednive operacii gi pravime na site skladovi:

`> 1 2 3 0 print -> 1 2 3` (0-ta oznacuva koj sklad da se iskoristi, vo slucajov 0-ti, odnosno posledniot(najgorniot) broj na 0-ti sklad)<br>
`> 1 2 3 0 clear -> `<br>
`> 1 2 3 + - 2 run -> operaciite se izveduvaat na 2 sklad`<br>
`> 1 2 3 1 loop -> operaciite se izveduvaat na 1 sklad, tolku kolku sto e predposledniot broj na 0-ti sklad, vo slucajov 3`<br>
`> 1 2 3 1 fun -> na 1 sklad, zapisi tolku ukazi kolku sto e predposledniot broj na 0-ti sklad, vo slucajov 3`<br>
`> 1 2 3 1 move -> na 1 sklad, zapisi tolku sledni broevi kolku sto e predposledniot broj na 0-ti sklad, vo slucajov 3 -> 3 2 1`<br>
`> 1 2 3 4 0 reverse -> gi prevrtuva site elementi na odreden sklad -> 4 3 2 1`<br>

i za kraj gi imame uste ovie 3:

`> then -> ako top() na glaven sklad == 0 -> promenliva b stavi na false, inace true`<br>
`> else -> promenlivata b smeni ja od true->false i obratno`<br>
`> ?... -> ako promenlivata b e true izrazot posle ? moze da se izvede`<br>

Mene problemot mi e so ovoj 2 riov del, koga treba da koristam povekje skladovi, odnosno sequence. Ne znam kako da go formiram sequencot i kako da go napolnam so stacks. Mi javuva greski sto i da napravam. Plus mala pomos mi treba okolu ova so then else ?.
