Реализованы 1-5 пункт из ТЗ на Kotlin.

Данные передаются в аргументы в виде id1-N1 ... idx-Nx card-xxxxx.
Порядок передачи аргументов не важен.

Объекты товаров генерятся в ProductRepositoryImpl, цена генерится случайно, по-этому с каждым запуском выходные данные 
будут отличаться.

При наличии акционных товаров кол-ом более 5, в строке товара в конце в скобках указывается скидка (цена перед скобками 
указана полная, без учета скидки).

В конце чека указана ПОЛНАЯ стоимость без учета скидок, скидка за опт (>5 акционных товаров),скидка по карте, итоговая 
стоимость. 

Скидка по карте считается после применения скидки за опт (например: 10 акционных товаров по 1.00. Итого 10.00. Скидка за
опт = 10*0.1 = 1.00. Карта SILVER (-3%). Скидка по карте = (10-1)*0.03 = 0.27. К оплате 8.73)