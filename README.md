# Dwa ekrany

Aplikacja z dwoma ekranami: formularz zapisu na kurs i podsumowanie.
Dane przechodzą przez putExtra, a potwierdzenie wraca z numerem zgłoszenia
przez ActivityResultLauncher. Przycisk Udostępnij używa intencji niejawnej.

<img width="1080" height="2400" alt="Screenshot_20261116_011245" src="https://github.com/user-attachments/assets/2f921047-51d6-42e4-a424-89b418c713dc" />
<img width="1080" height="2400" alt="Screenshot_20261116_011257" src="https://github.com/user-attachments/assets/6fb9072d-f368-4f0d-8d0f-ce80fe2630df" />


## Dlaczego rejestracja wyniku jest polem klasy, a nie jest w obsłudze kliknięcia?

Rejestracja (registerForActivityResult) musi powstać, zanim ekran stanie się
widoczny. Gdy system zniszczy i odtworzy ekran, rejestracja musi już istnieć,
żeby wynik z drugiego ekranu miał dokąd wrócić. Wywołanie jej w obsłudze
kliknięcia kończy się wyjątkiem "LifecycleOwners must call register before
they are STARTED".

## Co zobaczy ekran wywołujący po naciśnięciu Wstecz na drugim ekranie?

Dostaje wynik RESULT_CANCELED (ustawiany automatycznie), a data jest pusta.
Warunek w launcherze (resultCode == RESULT_OK) nie jest spełniony, więc na
pierwszym ekranie nic się nie dzieje: nie pojawia się Snackbar z numerem.
Sprawdziłem to na emulatorze.
