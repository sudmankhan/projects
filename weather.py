import requests

api_key = "f3c3741f5433dda4d8cb03cc91448ca1"
city = input("Enter city name: ")

url = f'http://api.openweathermap.org/data/2.5/weather?q={city}&appid={api_key}'

response = requests.get(url)

if (response.status_code == 200): 
    data = response.json()
    # print(data)
    temp = round((data['main']['temp'] - 273.15) * 9 / 5 + 32)
    feels_like = round((data['main']['feels_like'] - 273.15) * 9 / 5 + 32)
    temp_min = round((data['main']['temp_min'] - 273.15) * 9 / 5 + 32)
    temp_max = round((data['main']['temp_max'] - 273.15) * 9 / 5 + 32)
    weather = data['weather'][0]['main'].title() 
    description = data['weather'][0]['description'].title() 
    print(f'\nCurrent Weather in {city.title()}: {description}')
    # print(f'Description: {description}')
    print(f'Temperature: {temp} °F')
    print(f'Feels like: {feels_like} °F')
    print(f'Min Temp: {temp_min} °F')
    print(f'Max Temp: {temp_max} °F')
else:
    print('City not found.')