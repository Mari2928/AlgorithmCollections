# set matplotlib backend to inline
%matplotlib inline 

# import modules
from sklearn import datasets 
import numpy as np 
import matplotlib.pyplot as plt 
import pandas as pd

# load data
wine=datasets.load_wine()
#print(wine.DESCR)

# this dataset has 13 features, we will only choose a subset of these
df_wine = pd.DataFrame(wine.data, columns = wine.feature_names )
selected_features = ['alcohol','flavanoids','color_intensity','ash']

# extract the data as numpy arrays of features, X, and target, y
X = df_wine[selected_features].values
y = wine.target

###############################################################################
# Pandas manipulation

# Read CSV data
df = pd.read_csv('fastfood.csv')

# Combine sub-categories into a single category
df['location'] = df[['shore', 'southj', 'centralj', 'northj', 'pa1', 'pa2']].idxmax(axis=1)

# Change the data type to category
df['chain'] = df['chain'].astype('category')

# compute median
wage_dif_median = (df['wage_st2'] - df['wage_st']).median()

# fill na for wage_st2 and wage_st
df.fillna({'wage_st2': df['wage_st'] + wage_dif_median, 
           'wage_st': df['wage_st2'] - wage_dif_median}, inplace=True)

# drop the rest of NaN value and reindex
df.dropna(inplace=True)
df.reset_index(drop=True, inplace=True)

# add a new column (3 ways)
df['new_col'] = df['emppt2'] - df['emppt'] 
df['new_col'] = my_list
se = pd.Series(mylist)
df['new_col'] = se.values

# create a series
s1 = pd.Series(['X1', 'X2', 'X3'], index=['ONE', 'TWO', 'THREE'], name='X')
# ONE      X1
# TWO      X2
# THREE    X3

# choose numerical columns only to summarize statistics
cols = ['empft', 'emppt', 'empft2', 'emppt2',
        'wage_st', 'wage_st2', 'change_ft', 'change_pt']
df[cols].describe()

# numerical columns to a dataframe
df_numerical = pd.DataFrame(df[cols])

# show median of each numerical columns
df_numerical.median()

# drop 'location' column 
df.drop(columns=['location'], inplace=True)

# Create a categorical boolean mask
categorical_feature_mask = df.dtypes == 'category'

# Filter out the categorical columns into a list
categorical_cols = df.columns[categorical_feature_mask].tolist()

# numpy to dataframe
df = pd.DataFrame(data=[[1, 2, 3], [4, 5, 6]], columns=['a', 'b', 'c'])
print(df)
#    a  b  c
# 0  1  2  3
# 1  4  5  6

# dataframe to numpy
a_df = df.values
print(a_df)
# [[1 2 3]
#  [4 5 6]]

# extract features for X and y 
X = df.drop(['change_ft', 'empft2','emppt2'], axis=1)
y = df['change_ft'].values

###############################################################################
# Numpy manipulation

# create a numpy array
numpy_arr = np.array([[1,2],[3,4]])

# transpose
numpy_arr.T

# reshape
a = np.arange(12).reshape((4, 3))
# [[ 0  1  2]
#  [ 3  4  5]
#  [ 6  7  8]
#  [ 9 10 11]]

# add random noise
X = X + np.random.normal(0, 0.4, X.shape)

# the number of samples
X.shape[0]  # 150

# the number of features
X.shape[1]  # 5

# the number of classes
np.unique(y)  # [0 1 2]

# the number of samples belong to class 1
len(np.where(y==1)[0]) # 50

# a list of indices that is not shuffled
L = list(range(X.shape[0])) # [0 1 2 3 4]

# a list of indices that is shuffled
L = np.random.permutation(L) # [4 0 2 1 3]


###############################################################################
# create a regression model

from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score

# split to train and test
X_train, X_test, y_train, y_test = train_test_split(X, y,
                                                    test_size=0.2,
                                                    random_state=0)
# reset the model with the best parameters
lm_best = LinearRegression(copy_X=True,
                           fit_intercept=True,
                           normalize=False)
# fit the model
lm_best.fit(X_train, y_train)

# predict DiDft
y_pred = lm_best.predict(X_test)

# print the prediction result
print(y_pred.round(1))

# print the ground truth
print(y_test)

# print RMSE and R2
print('Mean Squared Error:' ,mean_squared_error(y_test, y_pred))
print('R2 score:' ,r2_score(y_test, y_pred))
