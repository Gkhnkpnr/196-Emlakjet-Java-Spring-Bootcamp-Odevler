# RabbitMQExample

- Spring Boot
- RabbitMQ
- Spring Data JPA
- Postgresql
- Spring Web

Postman Üzerinden İstek Gönderiyoruz.
![Screen Shot 2022-06-10 at 16 16 10](https://user-images.githubusercontent.com/46999778/173074920-530e7257-5c99-4d7d-9eb0-ad8f86a2e12c.png)


İsteği Karşılayan Producer Hem Queue'ya ekliyor hemde Database'e Taslak olarak ekliyor(priceGraphPath kısmı boş olacak şekilde)

![Screen Shot 2022-06-10 at 16 15 55](https://user-images.githubusercontent.com/46999778/173075425-3e7d8ce2-9b59-4802-9dc8-b8f768c98bb6.png)

Queue'dan mesajı alan Consumer tarafı taslak olarak gönderilen gönderiyi alıp priceGraphPath kısmını Updated by Worker olarak güncelliyor.


![Screen Shot 2022-06-10 at 16 18 48](https://user-images.githubusercontent.com/46999778/173075947-5a393b08-f902-47c2-a0ef-879a89dd6231.png)
