def fizz_buzz():
    for i in range(1, 101):
        out_str = ""
        if i % 3 == 0:
            out_str = "Fizz"
        if i % 5 == 0:
            out_str += "Buzz"
        if out_str == "":
            print(i)
        else:
            print(out_str)

def currency_convert():
    exchange_rate = float(input("Enter the current exchange rate to convert to: "))

    amount = float(input("Enter the amount you wish to convert: "))
    
    converted_amount = amount * exchange_rate

    print(f"After conversion, you have: ${converted_amount:.2f}")

def string_loop():
    string = "string"
    for letter in string:
        print(letter)
    for letter in reversed(string):
        print(letter)

def backwardString():
    try:
        userInputString = input("Please input a string")
    except ValueError as e:
        print("Please input a string")
    reversedString = ''.join(reversed(userInputString))
    print(reversedString)

def ice_cream_menu():
    def userInput():
        while True:
            try:
                print("1. Chocolate \n 2. Vanilla \n 3. Caramel")
                userSelectionString = input("Please input a menu number: ")
                userSelection = int(userSelectionString)
                if userSelection not in [1, 2, 3]:
                    raise ValueError("Incorrect input, please input either 1, 2 or 3")
                return userSelection  # Return only userSelection
            except ValueError as e:
                print("Incorrect input, please input either 1, 2 or 3")

    userSelectionInt = userInput()

    if userSelectionInt == 1:
        print("Chocolate")
    elif userSelectionInt == 2:
        print("Vanilla")
    elif userSelectionInt == 3:
        print("Caramel")

def int2Bool():
    while True:
        try:
            string = input("Enter 0 or 1")
            integer = int(string)
            boolean = bool(integer)

            if boolean not in [True, False]:
                raise ValueError("Incorrect input, please input either 0 or 1")
            
            print(f"Boolean Value: {boolean}")
            return boolean 

        except ValueError as e:
            print(str(e))
            continue

def bool2Int():
    while True:
        try:
            string = input("Enter True or False: ").strip().upper()
            if string not in ["TRUE", "FALSE"]:
                raise ValueError("Incorrect input, please input either True or False")
            
            if string == "TRUE":
                integer = 1
            else:
                integer = 0
            
            print(f"Integer Value: {integer}")
            return integer

        except ValueError as e:
            print(str(e))
            continue 

bool_value = int2Bool()
print(f"The boolean value is: {bool_value}")

int_value = bool2Int()
print(f"The integer value is: {int_value}")

    













def je_m_appelle():
    """
    Function to collect the users first and last name (string)
    """
    try:
        firstName = input("What's your first name?")
        lastName = input("What's your last name?")
    except ValueError:
        print("Incorrect values, please use letters")
        je_m_appelle()

    return firstName, lastName

def ride_restriction():
    """
    Function to collect the users height (int)
    messages are printed dependent on the user input
    """
    def height_collect():
        while True:
            try:
                userHeight = input("What is your height in cm? ")
                if len(userHeight) > 3 or len(userHeight) < 2:
                    print("Incorrect input, please input your real height")
                    continue
                intHeight = int(userHeight)
                if isinstance(intHeight, int): 
                    break 
            except ValueError:
                print("Incorrect values, please use numbers.")
            
        return intHeight 
    
    intHeight = height_collect()
    
    if intHeight <= 150:
        print("Sorry, for safty reasons, you cannot ride the roller coaster")
    elif intHeight >= 210:
        print("Sorry, for safty reasons, you cannot ride the roller coaster")
    else:
        print("Welcome them to the ride!")

    return intHeight

def height2inches(userHeightCm):
    """
    Function to covert height in cm to iches
    """
    userHeightInch = userHeightCm / 2.54
    print(f"Your height in Inches is: \n{userHeightInch}")

    return userHeightInch

def main():
    firstName, lastName = je_m_appelle()

    userHeightCm = ride_restriction()

    userHeightInch = height2inches(userHeightCm)

if __name__ == "__main__":
    main()