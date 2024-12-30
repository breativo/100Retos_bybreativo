# Solución en Python
import random

def print_stats(total_games, total_coins_won, wins, wildcard_wins, longest_losing_streak):
    print("\nJuego terminado. Estas son tus estadísticas:")
    print(f"Jugadas realizadas: {total_games}")
    print(f"Monedas ganadas: {total_coins_won}")
    print(f"Monedas gastadas: {total_games}")
    print(f"Aciertos logrados: {wins}")
    print(f"Combinaciones con comodín: {wildcard_wins}")
    print(f"Racha más larga sin aciertos: {longest_losing_streak}")

def play_game():
    icons = ["🍒", "🔔", "🍋", "💎", "⭐", "🎲", "🌈", "🔥", "🍉", "🌟"]
    coins = 25
    total_games = 0
    wins = 0
    total_coins_won = 0
    longest_losing_streak = 0
    current_losing_streak = 0
    wildcard_wins = 0

    print("Bienvenido a la Máquina Tragaperras con Comodín")
    print(f"Comienzas con {coins} monedas. ¡Buena suerte!\n")

    while coins > 0:
        choice = input("Presiona 'a' para jugar o 'b' para salir: ").lower()

        if choice == 'b':
            break
        elif choice == 'a':
            coins -= 1
            total_games += 1

            result = [random.choice(icons) for _ in range(3)]
            print("Resultado:", " ".join(result))

            is_win = False
            if result[0] == result[1] == result[2]:
                is_win = True
            elif "🎲" in result and (result[0] == result[1] or result[1] == result[2] or result[0] == result[2]):
                is_win = True
                wildcard_wins += 1

            if is_win:
                coins_won = coins
                coins += coins_won
                total_coins_won += coins_won
                wins += 1
                current_losing_streak = 0
                print(f"¡Ganaste! Has ganado {coins_won} monedas. Tu saldo es de {coins} monedas.\n")
            else:
                current_losing_streak += 1
                longest_losing_streak = max(longest_losing_streak, current_losing_streak)
                print(f"No hubo acierto. Te quedan {coins} monedas.\n")
        else:
            print("Opción no válida. Intenta nuevamente.")

    print_stats(total_games, total_coins_won, wins, wildcard_wins, longest_losing_streak)

if __name__ == "__main__":
    play_game()
