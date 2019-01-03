import gspread
from oauth2client.service_account import ServiceAccountCredentials

scope=['https://spreadsheets.google.com/feeds', 'https://www.googleapis.com/auth/drive']

credentials = ServiceAccountCredentials.from_json_keyfile_name("My Project-150473bd33ba.json",scope)

gc=gspread.authorize(credentials)

wks=gc.open('Alumnos').sheet1

print(type(wks))
print(wks.get_all_values())
